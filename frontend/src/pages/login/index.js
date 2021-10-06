import React from 'react';
import { Input, Button } from 'antd';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

const Title = styled.h2`
  width: 60px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const LoginEmailDiv = styled.div`
  padding: 10px;
  width: 500px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const LoginPasswordDiv = styled.div`
  padding: 10px;
  width: 500px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const LoginEmailInput = styled(Input)`
  border-radius: 10px 10px 10px 10px;
`;

const LoginPasswordInput = styled(Input.Password)`
  border-radius: 10px 10px 10px 10px;
`;

const LoginSpan = styled.span`
  
`;

const LoginEnterDiv = styled.div`
  padding: 10px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const LoginEnterButton = styled(Button)`
  background: #7EA592;
  color: white;
  width: 480px;
  height: 50px;
  font-size: 22px;
  border-radius: 6px 6px 6px 6px;
`;

const StyledHr = styled.hr`
  width: 700px;
  border-bottom: 0px;
  text-align: left;
  margin-left: 0px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const LoginLinkDiv = styled.div`
  padding: 20px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const LoginLink = styled(Link)`
  color: #000000;
`;

/* const StyledCenter = styled.div`
  padding: 20px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`; */


function Login() {

  return (
    <>
      <div className="login-header">
        <Title>LOGIN</Title>
      </div>
      <div className="login-body">
        <LoginEmailDiv>
          <LoginSpan>E-MAIL</LoginSpan>
          <LoginEmailInput />
        </LoginEmailDiv>  
        <LoginPasswordDiv>
          <LoginSpan>PASSWORD</LoginSpan>
          <LoginPasswordInput />
        </LoginPasswordDiv>
        <LoginEnterDiv>
          <LoginEnterButton>ENTER</LoginEnterButton>
        </LoginEnterDiv>
      </div>
      <LoginLinkDiv>
        <LoginLink to="/join">JOIN </LoginLink>/
        <LoginLink to="/join"> FIND ID </LoginLink>/
        <LoginLink to="/join"> FIND PASSWORD</LoginLink>
      </LoginLinkDiv>
      <div className="login-footer">
        <StyledHr />
        {/* 로그인 API 향후 개발 */}
      </div>
    </>
  );
};

export default Login;
