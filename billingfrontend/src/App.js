import './App.css';
import profile from "./image/profile.jpg"
import mail from "./image/mail.png"
import pass from "./image/lock.png"


function App() {
  return (
    
     <div className='main'>
       <div className='sub_main'>
          <div className='imgs'>
            <div className='container-imge'>
             <img src={profile} className="profile" />
            </div>
          </div>

          <div>
            <h1>Logging page</h1>
            <div>
             <img src={mail} alt='email' className='email'/>
             <input type='text' placeholder='User name' className='name'/>
            </div>
            <div className='second-input'>
            <img src={pass} alt='Password' className='email'/>
             <input type='text' placeholder='Enter your password' className='name'/>
            </div>
            <div className='login-button'>
            <button>Login</button> 
            </div>
              
                <p className="link">
                <a href="#">Forgot password ?</a> 
            </p>


          </div>

       </div>
     </div>
     
  );
}

export default App;
