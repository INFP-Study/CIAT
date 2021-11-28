import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import styled from 'styled-components';
import { signUp } from '../../store/auth';
import SignUp from '../../components/auth/sign-up';
import { message, notification } from 'antd';
import { REQUIRED_CHECK, SIGN_UP_SUCCESS } from '../../constants';

const Wrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

function SignUpContainer() {
  const selector = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  const [info, setInfo] = useState({
    email: '',
    nickname: '',
    password: '',
    passwordConfirm: '',
  });
  const [isEmpty, setIsEmpty] = useState(false);

  const onChangeHandler = (e) => {
    setInfo({
      ...info,
      [e.target.name]: e.target.value,
    });
  };

  const onSignUpHandler = (e) => {
    const res = dispatch({ type: signUp.type, data: info });
    res !== undefined ? openNotification() : '';
  };

  const openNotification = () => {
    notification.success({
      message: 'CIAT',
      description: SIGN_UP_SUCCESS,
    });
  };

  const emptyError = (e) => {
    setIsEmpty(true);
    message.error(REQUIRED_CHECK);
  };

  const notEmptyError = (e) => {
    setIsEmpty(false);
  };

  const emptyValueCheck = (e) => {
    e.target.name === e.currentTarget.name && e.target.value === ''
      ? emptyError(e)
      : notEmptyError(e);
  };

  return (
    <Wrapper>
      <SignUp
        handleChange={onChangeHandler}
        handleSignUp={onSignUpHandler}
        emptyValueCheck={emptyValueCheck}
      />
    </Wrapper>
  );
}

export default SignUpContainer;
