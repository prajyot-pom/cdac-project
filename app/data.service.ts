import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class DataService {
  baseUrl="http://localhost:8080/book_store/books/"
  userUrl="http://localhost:8080/book_store/users/"

  constructor(public http:HttpClient) {
  }
   getBookData(){
    return this.http.get(this.baseUrl);
   }

   getUserData()
   {
      return this.http.get(this.userUrl);
   }

   getAddressData(id)
   {
     console.log("inside getAddress of service");
    return this.http.get("http://localhost:8080/book_store/users/addr/"+id);
   }

   getCartData(id)
   {
     console.log("inside get cart data method of service");
     return this.http.get("http://localhost:8080/book_store/users/cart/"+id);
   }
   AddData(book){
     console.log(book); 
     return this.http.post("http://localhost:8080/book_store/books",book);
   }

   AddUserData(user)
   {
     console.log(user);
     return this.http.post("http://localhost:8080/book_store/users",user);
   }

   AddAddress(address,userId)
   {
     console.log("inside add address of service");
      return this.http.post("http://localhost:8080/book_store/address/"+userId,address);
   }

   AddOrder(bookId, userId)
   {
     console.log("inside addOder of service" + bookId+""+userId);
     return this.http.get("http://localhost:8080/book_store/orders/"+bookId+"/"+userId);
   }

   deleteBook(no){
    return this.http.delete(this.baseUrl+no);
   }

   deleteUser(no){
    return this.http.delete(this.userUrl+no);
   }

   deleteAddress(id, userId)
   {
     return this.http.delete("http://localhost:8080/book_store/address/"+id+"/"+userId);
   }

   deleteItem(id,userId)
   {
      return this.http.delete("http://localhost:8080/book_store/items/"+id+"/"+userId)
   }

   getBookDataById(no){
    return this.http.get(this.baseUrl+no);
   }

   getUserDataById(no){
    return this.http.get(this.userUrl+no);
   }

   getAddressDataById(id)
   {
     return this.http.get("http://localhost:8080/book_store/address/"+id);
   }

   updateBook(bookobj)
   {
     console.log(bookobj);
    bookobj = this.http.post("http://localhost:8080/book_store/books/update",bookobj);
    return bookobj;
   }

   updateUser(userobj)
   {
     console.log("inside data service updateUser method....")
     console.log(userobj);
     userobj = this.http.post("http://localhost:8080/book_store/users/update",userobj);
      return userobj;
   }

   updateAddress(addressObj)
   {
      addressObj=this.http.post("http://localhost:8080/book_store/address/update",addressObj);
      return addressObj;
   }

   changePwd(id,user)
   {
     user = this.http.post("http://localhost:8080/book_store/users/changepwd/"+id,user);
     return user;
   }

   AddToCart(bookId, qty, userId,title,price)
   {

    console.log(bookId);
    console.log(qty);
    console.log(userId);
    console.log(title);
    console.log(price);
     return this.http.get("http://localhost:8080/book_store/items/"+bookId+"/"+qty+"/"+userId+"/"+title+"/"+price);
    
   }

   getPaymentAmount(userId)
  {
    return this.http.get("http://localhost:8080/book_store/users/payment/"+userId);
  }

  Search(title)
  {
    return this.http.get("http://localhost:8080/book_store/books/search/"+title);
  }

  clearCart(userId)
  {
    console.log("inside clear cart method")
    return this.http.get("http://localhost:8080/book_store/users/clear/"+userId)
  }
}
