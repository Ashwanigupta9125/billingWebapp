export default function Test() {
   // let val=document.getElementById("frm");

  function myfun(event){
    let x1=document.forms['frm'].elements;
    console.log(x1);
     //console.log(x1[0].name);
    //  console.log(x1[1].name);
    //  console.log(x1[2].name); 

    //let x1=[1,2,3,4]

    console.log("request send.............");

  }
  


 

   return (
     <div>
         <form id='frm' action="http://localhost:8080/check" method="post">
           First namr: <input type='text' name='fname'  id='fname'/> <br/><br/>
           second name: <input type='text' name='pass'/><br/><br/>
 
           <input type='submit' onClick={myfun} onSubmit={myfun} />
         </form>
 
 
     </div>
   )
 }
 
 