import React from 'react'
import { Outlet,Navigate} from 'react-router-dom'
import { isLoggedIN } from './Auth';


const Privateroute = () => {

      
        return isLoggedIN() ? <Outlet/> : <Navigate to={"/login"}/>
    
        // if(isLoggedIN){
        //     return ( <>
        //       <h1>this is react outer </h1>
        //        <Outlet/>
        //     </>
        //     )
        //  }else{
        //     return (<Navigate to={"/login"}/>)
        //    }



}

export default Privateroute
