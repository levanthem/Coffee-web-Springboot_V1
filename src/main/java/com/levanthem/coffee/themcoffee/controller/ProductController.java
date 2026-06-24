package com.levanthem.coffee.themcoffee.controller;

import com.levanthem.coffee.themcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

// Cass nay lo xu ly lien quan san pham Product bao gồm, CRUD product. lomap url va san pham, request response. no phu trach url dinh dang crud product.
// lat dan no ban cai cho repositỏy và service
//lang nghe cac / trong url va xem ham nao phu hp url và thi goi ham do,
// 2 viec : lang nghe ham nao phu hôp, goi ham do
// viec 1 : no phai la Bean duoc new tu dong trong ram : vao ram va nghe
// viec 2: lang nghe nay la Controller
// ham nao thuoc url nao : tra ve html
// 1 url get ung voi 1 ham return "TRANG HTML", ham phai nam trong 1 thang controller
@Controller  // RESPONCONTROLLER nghe tra ve json
public class ProductController {
    @GetMapping("/result")
    public String   result(Model model){
        return  "result";  // . html  --> null
        //mot url tuong ung 1 ham co 1 thung Model tuong ung, lam sao lay thng tin o post id, name o /product/edit
        // ky thuat chuyen data tu model /product/edit sang model nay, o cau lenh redirect .

    }


    //ham update nay update 1 san pham xun db, duoc goi boi viec nhan nut save
    // va nhan vao cac gia tri goi trong o dua len
    //@RequestParam("id") String id  gui tung o nhap o form gui len server, map vao bien hung trong ham, bien trong ham ko can giong bien duoi form gui len\
    //nhung @RequestParam("id")  = @RequestParam("ten bien o ben form html thuoc tinh "name" cua  o nhap ")
    @PostMapping("/products/edit")   // String id la bien cua ham , @requestParam(id) id nay la bien name o html gui len.
    public String Update(RedirectAttributes redirectAttributes, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("price") String price   , Model model) {
       // 2 lenh nay vo dung neu dung redirect, riderect dung thung khac
        model.addAttribute("msg", " Da edit thanh cong - MOCK message!!!");
        model.addAttribute("pname", name);

        //
        // thung do co 2 mon: cau thonog bao va ten san pham
//        return "result";  //.html
        redirectAttributes.addFlashAttribute("msg", "Da edit thanh cong - MOCK message!!!");
        redirectAttributes.addFlashAttribute("pname", name);
        return "redirect:/result";  //.html   --> goi lai url moi hoan toan

        // voi ham post ban chat get nhung co gui data len ham truoc khi get, nen neu url ko doi se bi resubmit khi refresh page, dupliate data gui len
        // do do phai tra ve trang result phai doi url result luon
        // URL dang van giu nguyen, than trinh duyet  co data  tra ve

    }

    //@RequestMapping("/products")   ghi vay ko tot , do dung chung cho ca post va Get.
    //@RequestMapping(path={"/jack","/products"},method = RequestMethod.GET)   // tren url haoc /jack  hoac /products
    //@GetMapping(path={"/jack","/products"})  // viet kieu ngan gon hon
    //@GetMapping(path = {"/products/edit/CFLVT1","/products/edit/CFLVT2","/products/edit/CFLVT3"})  , viet vay cung chet, con nhieu nua
    @GetMapping("/products/edit/{pid}")  // tach url 2 phan (co dinh va thay doi , phan thay doi path variable
    public String Edit(Model model, @PathVariable("pid") String id){
        // da trich duoc id tu url dua vao
        // To Do: dung serivce goi repo de where trong table product ra san pham co id vua click , lam sau
        // Tam thoi mock, hardcode
        Product selectedProduct;
        if(id.equalsIgnoreCase("CFLVT1")){
            selectedProduct = new Product("CFLVT1","Le Van Them 1",20_000.0);
        }else if (id.equalsIgnoreCase("CFLVT2")){
            selectedProduct =new Product("CFLVT2","Le Van Them 2",30_000.0);
        }else {
            selectedProduct =new Product("CFLVT3","Le Van Them 3",40_000.0);
        }

        model.addAttribute("selectProEdit",selectedProduct);

        return "product-form";
    }
    @GetMapping("/products")  // neu chi map 1 link
    public String List(Model model){  // List show danh sach san pham

            model.addAttribute("msg", "Xin chao Admin!!!");
            // Chuan bi 1 danh sach san pham chuan bi show ra
            List<Product> productList = new ArrayList<>();
            productList.add(new Product("CFLVT1","Le Van Them 1",20_000.0));
            productList.add(new Product("CFLVT2","Le Van Them 2",30_000.0));
            productList.add(new Product("CFLVT3","Le Van Them 3",40_000.0));
            model.addAttribute("products", productList);
        return "products";  // reeurn tên trang - view , ko cần .html, tự thymeleà nó lo gắn tên
        // Khi controller timf thay ham xu ly url tương ứng, nó sẽ gọi hàm này
        // Nhưng trước khi gọi, nó gửi cho hàm một thùng chứa đồ rỗng gọi là MODEL
        //MIÌnh nhét data vào thùng chứa đồ này, Thùng đồ model được new tự động, và chích vào xử lý URL.
        //  khi thuc thi  lệnh return chouurrl get , spring boot nó sẽ đính kèm thùng dồd vào cùng trang trả về và đưa tên trang
        //+ thùng đồ cho themeleaf trộn render
        // Themeleaf lấy đồ trong thùng trộn với các Tag HTML , trọn xong trả cho TOMCAT HTML ngon, --> Đẩy về trình duyệtuser

        // Câu hỏi la sao nhét đồ - Data vào thùng v lấy ra
        // Controller là nhét đồ vào thùng,
        // HTML /Thymeleaf thì lấy đồ ra khỏi thùng và mix

        // Quy tác:
        // Tưởng tượng tủ gửi đồ , quầy gửi túi, giỏ  siêu thị TTTM
        // Bỏ đồ vào học tủ , lấy chìa khóa, thẻ gửi đồ

        //Chìa khóa mảnh giấy gọi là key, gói đồ gọi là value /////
        //model.addAtribute(key,value)  // chuôi ko trùng object bất kỳ bạm muốn cất
        //tên biến, value
        // lát hồi bên trang view chỉ cần tr đến key sẽ ra value
        // $ {tên key, mảnh giấy}  --> trả về object mốn đồ

        // gửi đồ cho view bỏ vào học tủ
    }
}
