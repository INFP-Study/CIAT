import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import {
  DOCUMENT_URL,
  FEED_ROUTE,
  FEED_URL,
  MAIN_URL,
  PLANT_MANAGEMENT_URL,
  SETTING_URL,
  SIGNIN_URL,
} from '../../constants/urls';
import Document from '../../pages/document';
import Feed from '../../pages/feed';
import Home from '../../pages/home';
import Login from '../../pages/login';
import PlantManagement from '../../pages/plant-management';
import Setting from '../../pages/setting';

function index() {
  return (
    <BrowserRouter>
      <Route exact path={SIGNIN_URL} component={Login} />
      <Route exact path={PLANT_MANAGEMENT_URL} component={PlantManagement} />
      <Route exact path={FEED_URL} component={Feed} />
      <Route path={FEED_ROUTE} component={Feed} />
      <Route exact path={SETTING_URL} component={Setting} />
      <Route exact path={DOCUMENT_URL} component={Document} />
      <Route exact path={MAIN_URL} component={Home} />
    </BrowserRouter>
  );
}

export default index;
