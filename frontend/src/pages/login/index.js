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

const EmailDiv = styled.div`
  padding: 10px;
  width: 500px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const PasswordDiv = styled.div`
  padding: 10px;
  width: 500px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const EmailInput = styled(Input)`
  border-radius: 10px 10px 10px 10px;
`;

const PasswordInput = styled(Input.Password)`
  border-radius: 10px 10px 10px 10px;
`;

const EnterDiv = styled.div`
  padding: 10px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const EnterButton = styled(Button)`
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

const LinkDiv = styled.div`
  padding: 20px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const StyledSpan = styled.span`
  /* 향후 글꼴 적용 */
`;

const StyledLink = styled(Link)`
  color: #000000;
`;

function Login() {

  return (
    <>
      <Title>LOGIN</Title>
      <EmailDiv>
        <StyledSpan>E-MAIL</StyledSpan>
        <EmailInput />
      </EmailDiv>  
      <PasswordDiv>
        <StyledSpan>PASSWORD</StyledSpan>
        <PasswordInput />
      </PasswordDiv>
      <EnterDiv>
        <EnterButton>ENTER</EnterButton>
      </EnterDiv>
      <LinkDiv>
        <StyledLink to="/join">JOIN </StyledLink>/
        <StyledLink to="/join"> FIND ID </StyledLink>/
        <StyledLink to="/join"> FIND PASSWORD</StyledLink>
      </LinkDiv>
      <StyledHr />
      {/* 로그인 API 향후 개발 */}
    </>
  );
};

export default Login;
