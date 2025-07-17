import { Component, OnInit,Inject, PLATFORM_ID ,Input,Output} from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { Course, User, Usercourse, Wishcourse } from '../entities';
import { UserService } from '../user.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { Concept ,topic} from '../entities';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';


@Component({
  selector: 'app-full-screen-course',
  templateUrl: './full-screen-course.component.html',
  standalone : true,
  imports : [FormsModule,CommonModule,FooterComponent,HeaderComponent],
  styleUrls: ['./full-screen-course.component.scss'],
})
export class FullScreenCourseComponent  implements OnInit {

  buttontext = "Wishlist"
  constructor(private userservice : UserService,private sanitizer: DomSanitizer,private route : ActivatedRoute,@Inject(PLATFORM_ID) private platformId: Object,private router : Router) { }
  @Input() course : any = { 
    courseid :  0,
    category :  0,
    name : '',
    descriptionmarkup : '',
    isfree :  '',
    points :  100,
    diffculty :  '',
    active : 1,
    createat : 0,
    updatedat : 0
  }
  checkingcourse : any = new Course()
  checkingwishcourse : any = new Wishcourse()

  wishcourseid : number = 0;
   
  subscriptionstartdate = new Date()

  wishcourse : Wishcourse = new Wishcourse()
  coursetoadduserlearning : Usercourse = new Usercourse()
  topics : topic[] = []
  conceptarray : Concept[] = []
  imgurl :  SafeResourceUrl | null = null;
  imgid : string = '';
  wishlistcourseadded : any = new Wishcourse()
  courseId : number = 0;

  usercourses : any[] = []
  wishcourses : any[] = []
  
  coursestatus = {
    wishliststatus : false,
    enrollstatus : false
  }

  user : User = new User()
  ngOnInit() {
    this.courseId = Number(this.route.snapshot.paramMap.get('courseid')) 
    this.userservice.getcoursefromcourseid(this.courseId).subscribe(
      (response)=>{
         this.course = response
      },(error)=>{
          console.log(error)
      }
    )
    if (isPlatformBrowser(this.platformId)) {
      const email = window.localStorage.getItem("elearning")??''
      if(email!=null && email!=''){
          this.userservice.getuserfromemail(email).subscribe((response)=>{
                this.user = response;
                this.userservice.getwishlistedcourse("wishlistedcoursefromuserid",this.user.userid || 0).subscribe(
                  (response)=>{
                        this.wishcourses = response
                        this.wishcourses.map((course)=>{
                            if(course.course.courseid == this.courseId){
                              this.wishcourseid = course.wishcourseid
                              this.coursestatus.wishliststatus = true
                            }
                        })
                  },(error)=>{
                      console.log(error)
                  }
                )
                this.userservice.getusercourses("usercoursefromuserid",this.user.userid || 0).subscribe(
                  (response)=>{
                    this.usercourses = response
                    console.log(this.usercourses)
                    this.usercourses.map((course)=>{
                      if(this.courseId == course.course.courseid){
                        this.coursestatus.enrollstatus = true
                      }
                    })
                  },(error)=>{
                    console.log(error)
                  }
                )
          },(error)=>{
              console.log(error)
          })
      this.userservice.gettopicfromcourse("gettopicsfromcourseid",this.courseId).subscribe(
        (response)=>{
          this.topics = response
          console.log(this.topics)
          this.userservice.getconceptsfromtopicid("conceptsfromtopicid",response[0].topicid).subscribe(
            (response)=>{
              this.conceptarray = response
              this.imgid = response[0].descriptionmarkup.split("/")[4]
              this.imgid = this.imgid.split("?")[0]
              const url = `https://img.youtube.com/vi/${this.imgid}/0.jpg`
              this.imgurl = this.sanitizer.bypassSecurityTrustResourceUrl(url);
            },(error)=>{

            }
          )
        },
        (error)=>{
            console.log(error)
        }
      )
      }
    }else {
        this.router.navigate(["/login"])
    }
  }
  addcourseintowishlist(){
    this.buttontext = "wishlisted"
    /*this.course = this.userservice.gettrendingcourses().filter((course)=>{
      return course.courseid == this.courseId
    })*/
    
    this.wishcourse = this.course
    this.wishcourse.course = this.course.courseid;
    this.wishcourse.user = this.user.userid || 0;
    console.log(this.wishcourse)
    this.userservice.sendcoursetowishlist("addcourseintowishlist",this.wishcourse).subscribe(
      (response)=>{            
        this.wishlistcourseadded = response
        this.coursestatus.wishliststatus = true
        this.wishcourseid = this.wishlistcourseadded.wishcourseid
      },
      (error)=>{
        console.log(error)
      }
    )
  }

  spinnerstatus : boolean = true
  public buycourse(){
    this.spinnerstatus = false
    this.coursestatus.enrollstatus = true
    this.coursetoadduserlearning.user = this.user.userid || 0;
    this.coursetoadduserlearning.course = this.courseId
    this.coursetoadduserlearning.createat = new Date()
    this.coursetoadduserlearning.updatedat = new Date()
    this.coursetoadduserlearning.subscriptionstart = new Date()
    const duration = this.subscriptionstartdate.getDate()+30
    this.coursetoadduserlearning.subscriptionend.setDate(duration)
    this.userservice.addcoursetomylearning("addtomylearning",this.coursetoadduserlearning).subscribe(
      (response)=>{
        this.coursestatus.enrollstatus = true
      },
      (error)=>{
        
      }
    )
  }

  removefromwishlist(){
     this.userservice.removecoursefromwishlist("removecoursefromwishlist",this.wishcourseid).subscribe(
      (response)=>{
        console.log(response)
        this.coursestatus.wishliststatus = false
      },(error)=>{
        console.log(error)
      }
     )
  }

  alertButtons = ['Action'];
}
