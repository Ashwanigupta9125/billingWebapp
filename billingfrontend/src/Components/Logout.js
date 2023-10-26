import React from 'react'
import { doLogout } from './Auth'


export default function Logout() {

 function onSubmitHandle(){
   

   doLogout(()=>{
    console.log("LOggout complete");
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
    </div>
  )
}
