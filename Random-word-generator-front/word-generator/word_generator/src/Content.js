import './Content.css';
import React, { useEffect, useState } from "react";
import axios from 'axios';



export default function Content(){
  
  const [result, setResult] = useState('YOUR NEW BAND NAME');

  

  const update = () => {
    axios.get('https://random-word-api.herokuapp.com/word?lang=' + language+ '&number=' + wordCount + '&length=' + length  ).then((response) => {
        var seperateWords = response.data.map(function (word) {
            return ' ' +  word.toUpperCase() + ' ';
        });
      setResult(seperateWords);
    });
  }

  React.useEffect(update, []);

  const [wordCount, setWordCount] = useState(1);

  const [language, setLanguage]= useState('en');

  const [length, setLength]= useState('Number of words');

  const handleWordCountChange = event => {
    if(wordCount==0 || wordCount==null ){
      setWordCount(1);
    }
    setWordCount(event.target.value);}

  const handleLengthChange = event => {
    if(length==0 || length==null ){
      setLength(1);
    }
    setLength(event.target.value);}



  const handleLanguageChange = event => {
      if(language==null ){
        setLanguage('en');
      }
      setLanguage(event.target.value);}
    

  return ( 
    
    <>
        <div id="form">
                <div className="container">
                <div className="select-box">
                    <select onChange={handleLanguageChange}
                    value={language}>
                    <option>Choose language</option>
                    <option value={'en'}>English</option>
                    <option value={'it'}>Italian</option>
                    <option value={'es'}>Spanish</option>
                    </select>
                </div>
                </div>

                <div className="container">
                <div className="select-box">
                    <select onChange={handleLengthChange}
                    value={length}>
                    <option>Word length</option>
                    <option value={3}>3</option>
                    <option value={4}>4</option>
                    <option value={5}>5</option>
                    <option value={6}>6</option>
                    <option value={7}>7</option>
                    <option value={8}>8</option>
                    <option value={9}>9</option>
                    <option value={10}>10</option>
                    </select>
                </div>
                </div>

                <div>    
                <div className="container">
                <div className="select-box">
                    <select onChange={handleWordCountChange}
                    value={wordCount}>

                    <option value={1}>Number of words</option>
                    <option value={1}>1</option>
                    <option value={2}>2</option>
                    <option value={3}>3</option>
                    <option value={4}>4</option>
                    </select>
                </div>
                </div>                     
                
                <button id="button"  type="submit" onClick={update}>GENERATE</button>
                <br></br>

                </div>
                
            </div>

            <div id ="right_side_form">
               <p id="results_text">BAND NAME: {result}</p>
               <output name="res"></output>
            </div>
        </>
        
 );
}


