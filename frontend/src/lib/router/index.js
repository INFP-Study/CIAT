import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import Menu from '../../components/menu';
import { MAIN_URL, SIGNIN_URL } from '../../constants/urls';
import Home from '../../pages/home';
import Login from '../../pages/login';

function index() {
  return (
    <BrowserRouter>
      <Menu />
      <Route exact path={SIGNIN_URL} component={Login} />
      <Route exact path={MAIN_URL} component={Home} />
    </BrowserRouter>
  );
}

export default index;
