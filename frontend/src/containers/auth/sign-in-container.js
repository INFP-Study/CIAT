import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import SignIn from '../../components/auth/sign-in';

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function SignInContainer() {
  return (
    <Wrapper>
      <SignIn />
    </Wrapper>
  );
}

export default SignInContainer;
