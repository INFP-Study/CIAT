import React from 'react';
import SiteLayout from '../../components/common/layout';
import SignInContainer from '../../containers/auth/sign-in-container';

function SignIn() {
  return (
    <SiteLayout>
      <SignInContainer />
    </SiteLayout>
  );
}

export default SignIn;
