export class User {
    userid=0;
    username='';
    passwordhashsalted='';
    active=0;
    role='';
    name='';
    email='';
    createat : Date = new Date();
    updateat : Date = new Date();
  }
  
  export class category{
     categoryid=0;
     name='';
     active=0;
  }
   
  export class categorywithcourse{
   category : category = new category();
   course : Course[] = [];
  }
  export class Course{
     courseid=0;
     category:category = new category();
     name='';
     descriptionmarkup='';
     isfree=0;
     points=100;
     difficulty='';
     active=1;
     createat=new Date();
     updatedat=new Date();
  }
  
  export class Wishcourse{
     wishcourseid=0;
     user=0; 
     course=0;
     name='';
     descriptionmarkup='';
     isfree='';
     points=100;
     diffculty='';
     active=1;
     createat=new Date();
     updatedat=new Date();
  }
  
  export class Usercourse{
     usercourseid = 0;
     user=0; 
     course=0;
     subscriptionstart=new Date();
     subscriptionend=new Date();
     updatedat=new Date();
     createat=new Date();
  }
  
  export class topic{
    topicid : number = 0;
    course : number = 0;
    name : string = '';
    isOpen : boolean = false;
    active : number = 1;
    createat : Date = new Date();
    updatedat : Date = new Date();
  
  }
  
  export class Concept{
     conceptid : number = 0;
     topic : number = 0;
     title : string = '';
     descriptionmarkup : string = '';
     active : number = 1;
     creatat : Date = new Date(2024, 9, 30);
     updateat : Date = new Date(2024, 9, 30);
  }
  
  export class Review {
     reviewid : number = 0;
     course : Course = new Course()
     descriptionmarkup : string = '';
     user : User = new User();
  }
  
  export class question {
     questionid : number = 0;
     concept : Concept = new Concept();
     questionmarkup : string = '';
     correctoption : number = 1;
     answermarkup : string = '';
     diffculty : string = ''
     active : number = 1;
     createat : Date = new Date()
     update : Date = new Date()
  }
  
  export class test {
     testid : number = 0;
     user : User = new User();
     course : Course = new Course();
     topic : topic = new topic();
     datetime : Date = new Date();
     noofquestions : number = 0;
     createat : Date = new Date()
     update : Date = new Date()
  }
  
  export class Faquestion  {
     faquestionid : number = 0;
     user : number = 0;
     question : string = '';
     answer : string = '';
     createat : Date = new Date();
     updatedat : Date = new Date();
     isopen : boolean = false;
  }

    