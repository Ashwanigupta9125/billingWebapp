

export const isLoggedIN = () =>{
 let data =localStorage.getItem("data");
  
 if(data == null || data == '"Credentials Invalid !!"' ) return false;
 else return true;
 };





export const doLogin=(data,next)=>{
    localStorage.setItem("data",JSON.stringify(data));
    next()
};


export const doLogout =(next) =>{
localStorage.removeItem("data");

next()
};


export const getCurrentUserDetail =() =>{
  
    if(isLoggedIN){
        return JSON.parse(localStorage.getItem("data"));
    }else{
        return false;
    }
};

////// Set jwt token using Axios intercent 



