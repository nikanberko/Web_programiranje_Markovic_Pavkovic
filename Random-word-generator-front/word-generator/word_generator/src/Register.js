import './Register.css';
import React from 'react';

const register = () => {
    return (   
        <>
            <div id="form">
                <input type="text" placeholder='Ime:'/>
                <br></br>
                <input type="text" placeholder='Prezime:'/>
                <br></br>
                <input type="text" placeholder='E-mail:'/>
                <br></br>
                <input type="text" placeholder='Korisničko ime:'/>
                <br></br>
                <input type="text" placeholder='Lozinka:'/>
                <br></br>
                <button id="button" type="submit">REGISTRIRAJ SE</button>
                <br></br>
            </div>
            
                    
        </>
     );
}
 
export default register;