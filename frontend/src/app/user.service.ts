import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { WebClientService } from './web-client.service';
import { User,Course,category,Review,Usercourse,topic,Concept, Wishcourse, question, Faquestion, test } from './entities';
import { HttpHeaders, HttpParams } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(public webClient : WebClientService) {}

  applicationuser : User = new User()
  isLogged : boolean = false
  

  setUser(user : User){
    this.isLogged = true
    this.applicationuser = user
  }
  getUser(): User{
    return this.applicationuser;
  }

  getStatus(){
    return this.isLogged
  }
  public register(user: User)
  {
    return this.webClient.post<typeof user,typeof user>('/adduser',user);
  }

  getallcategories(){
    return this.webClient.get<category[]>("getallcategories")
  }

  public getAllUsers()
  {
    return this.webClient.get<User[]>('/getallusers');
  }

  public getTreadingcourse(url : string,points : number){
    return this.webClient.get<Course[]>(url+"/"+points);
  }

  public getreviews(url : string)
  {
    return this.webClient.get<Review[]>(url);
  }

  getusercoursesfromuserid(url : string){
    return this.webClient.get<Usercourse[]>(url+"/"+this.applicationuser.userid)
  }

  sendcoursetowishlist(url : string,wish : Wishcourse){
    return this.webClient.post<Wishcourse,typeof Wishcourse>(url,wish);
  }

  getconceptsfromtopicid(url : string ,topicid : number){
    return this.webClient.get<Concept[]>(url+"/"+topicid)
  }

  gettopicfromcourse(url : string , courseid : number){
    return this.webClient.get<topic[]>(url+"/"+courseid)
  }


  getcoursefromcourseid(courseId : number){
    return this.webClient.get<Course>("getcoursefromcourseid"+"/"+courseId)
  }

  usermanuallogin(user : string,pass : string) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
    
    const loginData = new HttpParams()
      .set('username', user)
      .set('password', pass)

    return this.webClient.post<typeof loginData,typeof User>("manualLogin",loginData)
  }

  getuserfromemail(email : string){
    return this.webClient.get<User>("userfromemail"+"/"+email)
  }

  getwishlistedcourse(url : string,userid : number){
    return this.webClient.get<Wishcourse[]>(url+"/"+userid)
  }

  addcoursetomylearning(url : string,usercourse : Usercourse){
    return this.webClient.post<Usercourse,typeof Usercourse>(url,usercourse)
  }

  getusercourses(url : string,user : number){
    return this.webClient.get<Usercourse[]>(url+"/"+user)
  }

  removecoursefromwishlist(url : string,wishcourseid : number){
    return this.webClient.delete<Wishcourse>(url+"/"+wishcourseid)
  }

  updateusernameandemail(user : User){
    return this.webClient.post<User,typeof User>("updatenameandemail",user)
  }

  getcategoriescoursesfromcategory(cat : number){
  
    return this.webClient.get<Course[]>("categories/"+cat)
  }

  addcourseintodatabase(url :string,course : Course){
    return this.webClient.post<Course,typeof Course>(url,course)
  }

  addtopicinotdb(url : string,topic : topic){
    return this.webClient.post<topic,typeof topic>(url,topic);
  }

  addconceptinotdb(url : string,concept : Concept){
    return this.webClient.post<Concept,typeof Concept>(url,concept);
  }

  addquestionfromconceptid(url : string,question : question){
    return this.webClient.post<question,typeof question>(url,question);
  }

  getallcourses(){
    return this.webClient.get<Course[]>("getallcourses")
  }

  getquestionbyconcept(conceptid : number){
    return this.webClient.get<question[]>("getquestionfromconcept"+"/"+conceptid)
  }

  getfaqs(){
    return this.webClient.get<Faquestion[]>("getfaqquestion")
  }

  getfaqbyuserid(userid : number){
    return this.webClient.get<Faquestion[]>("getfaqquestionbyuserid"+"/"+userid)
  }

  addfaquestion(url : string,faq : Faquestion){
    return this.webClient.post<Faquestion ,typeof Faquestion>(url,faq);
  }

  getreviewsbycourseanduser(course : number,user : number){
    console.log(course,user)
    return this.webClient.get<Review>("getreviewbyuserandcourse"+"/"+user+"/"+course);
  }
 
  getquestionfromconcept(conceptid : number){
    return this.webClient.get<question[]>("getquestionfromconcept"+"/"+conceptid)
  }

  addtestcompletedtest(url : string,test : test){
    return this.webClient.post<test,typeof test>(url,test);
  }

  addreview(url : string,review : Review){
    return this.webClient.post<Review,typeof Review>(url,review)
  }
  getoauthuser(){
    return this.webClient.get<User>("user");
  }

  sendotp(email : string){
    return this.webClient.get("sendOTPtoemail/"+email)
  }

  verifyotp(email : string,otp : string) {
    const loginData = new HttpParams()
      .set('email', email)
      .set('otp', otp)
    return this.webClient.post("emailverfication",loginData)
  }

  setnewpassword(user : User){
    return this.webClient.post<User,any>("setnewuserpassword",user)
  }

  googleauthlogin(user : any)
  {
    return this.webClient.post<typeof user,any>("authlogin",user)
  }

  getcoursesimilartoname(name : string){
    return this.webClient.get<Course[]>("getcoursesbyname/"+name)
  }
}



