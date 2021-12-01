import React from 'react';
import SiteLayout from '../../components/common/layout';
import SignUpContainer from '../../containers/auth/sign-up-container';

function SignUp() {
  return (
    <SiteLayout>
      <SignUpContainer />
    </SiteLayout>
  );
}

export default SignUp;
