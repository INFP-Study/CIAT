import React from 'react';
import { Switch, Route, BrowserRouter, Link, Redirect } from 'react-router-dom';
import {
  DOCUMENT_URL,
  FEED_ROUTE,
  FEED_URL,
  MAIN_URL,
  MOBILE_URL,
  PLANT_MANAGEMENT_URL,
  SETTING_URL,
  SIGN_IN_URL,
  SIGN_UP_URL,
} from '../../constants/urls';
import Document from '../../pages/document';
import Feed from '../../pages/feed';
import Home from '../../pages/home';
import SignIn from '../../pages/auth/sign-in';
import PlantManagement from '../../pages/plant-management';
import Setting from '../../pages/setting';
import SignUp from '../../pages/auth/sign-up';
import FeedDetail from '../../pages/feed-detail';
import NotFound from '../../pages/error';
import SiteLayout from '../../components/common/layout';
import Mobile from '../../pages/mobile';

function isMobile() {
  return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
    navigator.userAgent
  );
}

function index() {
  return (
    <BrowserRouter>
      <SiteLayout>
        <Switch>
          {isMobile() && <Redirect to={MOBILE_URL}></Redirect>}
          <Route exact path={MOBILE_URL} component={Mobile} />
          <Route exact path={SIGN_IN_URL} component={SignIn} />
          <Route exact path={SIGN_UP_URL} component={SignUp} />
          <Route
            exact
            path={PLANT_MANAGEMENT_URL}
            component={PlantManagement}
          />
          <Route exact path={FEED_URL} component={Feed} />
          <Route path={FEED_ROUTE} component={FeedDetail} />
          <Route exact path={SETTING_URL} component={Setting} />
          <Route exact path={DOCUMENT_URL} component={Document} />
          <Route exact path={MAIN_URL} component={Home} />
          <Route component={NotFound} />
        </Switch>
      </SiteLayout>
    </BrowserRouter>
  );
}

export default index;
