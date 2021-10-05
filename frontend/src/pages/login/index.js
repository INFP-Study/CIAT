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

const EmailArea = styled.div`
  padding: 10px;
  width: 500px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const PasswordArea = styled.div`
  padding: 10px;
  width: 500px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const StyledEmail = styled(Input)`
  border-radius: 10px 10px 10px 10px;
`;

const StyledPassword = styled(Input.Password)`
  border-radius: 10px 10px 10px 10px;
`;

const StyledSpan = styled.span`
  
`;

const EnterArea = styled.div`
  padding: 10px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const StyledButton = styled(Button)`
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

const LinkArea = styled.div`
  padding: 20px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const StyledLink = styled(Link)`
  color: #000000;
`;

const StyledCenter = styled.div`
  padding: 20px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;


function Login() {

  return (
    <>
      <div className="login-header">
        <Title>LOGIN</Title>
      </div>
      <div className="login-body">
        <EmailArea>
          <StyledSpan>E-MAIL</StyledSpan>
          <StyledEmail />
        </EmailArea>  
        <PasswordArea>
          <StyledSpan>PASSWORD</StyledSpan>
          <StyledPassword />
        </PasswordArea>
        <EnterArea>
          <StyledButton>ENTER</StyledButton>
        </EnterArea>
      </div>
      <LinkArea>
        <StyledLink to="/join">JOIN </StyledLink>/
        <StyledLink to="/join"> FIND ID </StyledLink>/
        <StyledLink to="/join"> FIND PASSWORD</StyledLink>
      </LinkArea>
      <div className="login-footer">
        <StyledHr />
        <StyledCenter>KAKAO&nbsp;&nbsp;NAVER&nbsp;&nbsp;GITHUB&nbsp;&nbsp;INSTAGRAM</StyledCenter>
      </div>
    </>
  );
};

export default Login;
