import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { signUpSuccess } from '../../store/auth';
import SignUp from '../../components/auth/sign-up';
import { message } from 'antd';
import { EMAIL_CHECK, PASSWORD_CHECK } from '../../constants';

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function SignUpContainer() {
  const dispatch = useDispatch();

  const authSelector = useSelector((state) => state.auth);

  const [info, setInfo] = useState({
    email: '',
    nickname: '',
    password: '',
    passwordConfirm: '',
  });

  const onChangeHandler = (e) => {
    setInfo({
      ...info,
      [e.target.id]: e.target.value,
    });
  };

  const onSignUpHandler = (e) => {
    if (isEmail(info.email) === undefined) {
      if (isSamePassword(info) === undefined) {
        dispatch({ type: signUpSuccess.type, data: info });
      }
    }
  };

  // 이메일 검증
  const isEmail = (email) => {
    const regExp =
      /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
    if (!regExp.test(email)) {
      console.log(email);
      return message.error(EMAIL_CHECK);
    }
  };

  // 비밀번호
  const isSamePassword = (info) => {
    if (info.password !== info.passwordConfirm) {
      return message.error(PASSWORD_CHECK);
    }
  };

  return (
    <Wrapper>
      <SignUp handleChange={onChangeHandler} handleSignUp={onSignUpHandler} />
    </Wrapper>
  );
}

export default SignUpContainer;
