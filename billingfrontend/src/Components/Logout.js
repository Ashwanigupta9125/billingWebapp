import React from 'react'
import { doLogout, isLoggedIN } from './Auth'
import { useState } from 'react';
import { Link } from 'react-router-dom';


export default function Logout() {

const [isHidden, setIsHidden] = useState(false);

 function onSubmitHandle(){
   
   doLogout(()=>{
    console.log("LOggout complete");
    setIsHidden(true)

    isLoggedIN();
   });
 }

  return (
    <div>
        <h1 className='card shadow-lg p-3 mb-5 bg-white rounded'>
            Are U sure ....<br/><br/>

            You want to LoggOut  
        </h1>
        
        <div className='text-center'>
        <button onClick={onSubmitHandle} type="button" class="btn btn-danger  btn-lg ">Logg  Out</button>

        </div>


        {isHidden &&  <div className="text-center my-3" >
                        <h1> Loggout Successfully .. .. .</h1>
                        <Link to="/login">
                        <button type="button" class="btn btn-primary" >Go To Loggin</button>
                        </Link>
                      </div>
                       
                        }
    </div>
  )
}
