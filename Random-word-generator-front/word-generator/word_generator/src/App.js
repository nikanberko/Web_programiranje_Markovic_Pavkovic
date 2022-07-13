import Header from './Header';
import Content from './Content';
import Footer from './Footer';
import Login from './Login';
import Register from './Register';


import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import React from "react";


function App() {

  return (
    <Router>
      <>
        <Switch>

          <Route exact path="/">
            <Header />
            <Content/>
            <Footer />
          </Route>

          <Route exact path="/login">
            <Header />
            <Login  />
            <Footer />
          </Route>

          <Route exact path="/register">
            <Header />
            <Register />
            <Footer />
          </Route>

        </Switch>
      </>
    </Router>
  );
}



export default App;
