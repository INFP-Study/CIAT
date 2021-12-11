import { message } from 'antd';
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import SignIn from '../../components/auth/sign-in';
import { signInSuccess } from '../../store/auth';

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function SignInContainer() {
  const dispatch = useDispatch();

  const [info, setInfo] = useState({
    email: '',
    password: '',
  });

  const onChangeHandler = (e) => {
    setInfo({
      ...info,
      [e.target.name]: e.target.value,
    });
  };

  const onSignInHandler = () => {
    if (info.email === '') {
      return message.error('이메일을 입력해주세요.');
    } else if (info.password === '') {
      return message.error('비밀번호를 입력해주세요.');
    }
    dispatch({ type: signInSuccess.type, data: info });
  };

  return (
    <Wrapper>
      <SignIn handleChange={onChangeHandler} handleSignIn={onSignInHandler} />
    </Wrapper>
  );
}

export default SignInContainer;
