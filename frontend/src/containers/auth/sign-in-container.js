import { message } from 'antd';
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import SignIn from '../../components/auth/sign-in';
import { signIn } from '../../store/auth';

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function SignInContainer() {
  const dispatch = useDispatch();
  const selector = useSelector((state) => state);

  const [info, setInfo] = useState({
    email: '',
    password: '',
  });

  const onChangeHandler = (e) => {
    setInfo({
      ...info,
      [e.target.id]: e.target.value,
    });
  };

  const onSignInHandler = () => {
    dispatch({ type: signIn.type, data: info });
  };

  return (
    <Wrapper>
      <SignIn handleChange={onChangeHandler} handleSignIn={onSignInHandler} />
    </Wrapper>
  );
}

export default SignInContainer;
