import React from "react";
import profile from "../image/profile.jpg"
import pass from "../image/lock.png"
import mail from "../image/mail.png"





export default function Logging() {
  
    function myfun(event){
        event.preventDefault();

       // let x1=document.forms['frm'].elements;
       // console.log(x1);
         //console.log(x1[0].name);
        //  console.log(x1[1].name);
        //  console.log(x1[2].name); 
    
        //let x1=[1,2,3,4]
    
        console.log("request send.............");
    
      }

 
    return (
    <div className='main'>
        <div className='sub_main'>
            <div className='imgs'>
                <div className='container-imge'>
                <img src={profile} alt="user pic" className="profile" />
                </div>
            </div>

            <div>
                <h1>Logging page</h1>
                <form id='frm' action="http://localhost:8080/check"  method="GET">
                <div>
                <img src={mail} alt='email' className='email'/>
                <input type='text' placeholder='Enter User ID'   className='name' name='user_id'/>
                </div>
                <div className='second-input'>
                <img src={pass} alt='Password' className='email'/>
                <input type="password" placeholder='Enter your password' className='name' name='password'/>
                </div>
                <div className='login-button'>
                <input className="logging-but"   type='submit' onClick={myfun} onSubmit={myfun} />
                </div>
                </form>
                  
                   
               

            </div>

        </div>
        </div>       
    
    )
    }
