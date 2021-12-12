import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { signUp } from '../../store/auth';
import SignUp from '../../components/auth/sign-up';
import { message } from 'antd';
import {
  EMAIL_CHECK,
  NICKNAME_CHECK,
  PASSWORD_CHECK,
  PASSWORD_SAME_CHECK,
} from '../../constants';

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
      if (isNickname(info.nickname) === undefined) {
        if (isPassword(info) === undefined) {
          dispatch({ type: signUp.type, data: info });
        }
      }
    }
  };

  // 이메일 검증
  const isEmail = (email) => {
    const regExp =
      /^(([^<>()\[\].,;:\s@"]+(\.[^<>()\[\].,;:\s@"]+)*)|(".+"))@(([^<>()[\].,;:\s@"]+\.)+[^<>()[\].,;:\s@"]{2,})$/i;
    if (!regExp.test(email)) {
      return message.error(EMAIL_CHECK, 5);
    }
  };

  // 닉네임 검증
  const isNickname = (nickname) => {
    const regExp = /^[가-힣|a-z|A-Z|0-9|]{2,12}$/;
    if (!regExp.test(nickname)) {
      return message.error(NICKNAME_CHECK, 10);
    }
  };

  // 비밀번호 검증
  const isPassword = (info) => {
    const regExp =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
    if (!regExp.test(info.password)) {
      return message.error(PASSWORD_CHECK);
    } else if (info.password !== info.passwordConfirm) {
      return message.error(PASSWORD_SAME_CHECK, 10);
    }
  };

  return (
    <Wrapper>
      <SignUp handleChange={onChangeHandler} handleSignUp={onSignUpHandler} />
    </Wrapper>
  );
}

export default SignUpContainer;
