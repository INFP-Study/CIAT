import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import Menu from '../../components/menu';
import Home from '../../pages/home';
import Login from '../../pages/login';

function index() {
  return (
    <BrowserRouter>
      <Menu />
      <Route exact path="/login" component={Login} />
      <Route exact path="/" component={Home} />
    </BrowserRouter>
  );
}

export default index;
