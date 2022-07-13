import './Login.css';
import React from 'react';

const login = () => {
    return ( 
        <>
            <div id="form">
                <input type="text" placeholder='Korisničko ime:'/>
                <br></br>
                <input type="text" placeholder='Lozinka:'/>
                <br></br>
                <button id="button" type="submit" onClick="">LOGIN</button>
                <br></br>
            </div> 
        </>
     );
}
 
export default login;