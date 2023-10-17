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
    <div className='main_loggin'>
        <div className='sub_main_loggin'>
            <div className='imgs_loggin'>
                <div className='container-imge_loggin'>
                <img src={profile} alt="user pic" className="profile_loggin" />
                </div>
            </div>

            <div>
                <h1>Logging page</h1>
                <form id='frm' action="http://localhost:8080/check"  method="GET">
                <div>
                <img src={mail} alt='email' className='email_loggin'/>
                <input type='text' placeholder='Enter User ID'   className='name_loggin' name='user_id'/>
                </div>
                <div className='second-input_loggin'>
                <img src={pass} alt='Password' className='email_loggin'/>
                <input type="password" placeholder='Enter your password' className='name_loggin' name='password'/>
                </div>
                <div className='login-button_loggin'>
                <input className="logging-but_loggin"   type='submit' onClick={myfun} onSubmit={myfun} />
                </div>
                </form>
            </div>

        </div>
        </div>       
    
    )
    }
