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

const Div = styled.div`
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

const Span = styled.span`
  /* 향후 글꼴 적용 */
`;

const InputAntd = styled(Input)`
  border-radius: 10px 10px 10px 10px;
`;

const ButtonAntd = styled(Button)`
  background: #7EA592;
  color: white;
  width: 480px;
  height: 50px;
  font-size: 22px;
  border-radius: 6px 6px 6px 6px;
`;

const LinkAntd = styled(Link)`
  color: #000000;
`;

const Hr = styled.hr`
  width: 700px;
  border-bottom: 0px;
  text-align: left;
  margin-left: 0px;
  display: table;
  margin-left: auto;
  margin-right: auto;
`;

function Login() {

  return (
    <>
      <Title>LOGIN</Title>
      <Div style={{ width: '500px', padding: '10px'}}>
        <Span>E-MAIL</Span>
        <InputAntd />
      </Div>  
      <Div style={{ width: '500px', padding: '10px'}}>
        <Span>PASSWORD</Span>
        <InputAntd />
      </Div>
      <Div style={{ padding: '10px' }}>
        <ButtonAntd>ENTER</ButtonAntd>
      </Div>
      <Div style={{ padding: '20px' }}>
        <LinkAntd to="/join">JOIN </LinkAntd>/
        <LinkAntd to="/join"> FIND ID </LinkAntd>/
        <LinkAntd to="/join"> FIND PASSWORD</LinkAntd>
      </Div>
      <Hr />
      {/* 로그인 API 향후 개발 */}
    </>
  );
};

export default Login;
