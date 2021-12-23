import React from 'react';
import { Input, Button, Space, Form } from 'antd';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import SiteLayout from '../common/layout';
import {
  EMAIL,
  PASSWORD,
  SEARCH_ID,
  SEARCH_PASSWORD,
  SIGN_IN,
  SIGN_UP,
} from '../../constants';
import { SIGN_UP_URL } from '../../constants/urls';
import {
  AppleOutlined,
  FacebookOutlined,
  GithubOutlined,
  InstagramOutlined,
} from '@ant-design/icons';
import { theme } from '../../style/theme';

const Title = styled.p`
  font-family: ${theme.fontNotoSans};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightBold};
  text-align: center;
`;

const Div = styled.div`
  padding: 12.5px;
  width: 100%;
`;

const ButtonAntd = styled(Button)`
  color: white;
  width: 480px;
  height: 50px;
  font-size: ${theme.fontSizeTitle02};
  border-radius: 6px;
  margin-top: 10px;
  &:hover,
  &:focus {
    background-color: ${theme.colorPrimary};
  }
`;

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 700px;
`;

const SNSLogin = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  border-top: 1px solid ${theme.colorLine};
  padding: 30px;
`;

function SignIn({ handleChange, handleSignIn }) {
  return (
    <Wrapper>
      <InnerWrapper>
        <Title>{SIGN_IN}</Title>
        <Form layout="vertical" onFinish={handleSignIn}>
          <Form.Item
            label="이메일"
            name="email"
            rules={[{ required: true, message: '이메일을 입력해주세요.' }]}
          >
            <Input onChange={handleChange} />
          </Form.Item>
          <Form.Item
            label="비밀번호"
            name="password"
            rules={[{ required: true, message: '비밀번호를 입력해주세요.' }]}
          >
            <Input.Password onChange={handleChange} />
          </Form.Item>
          <Form.Item>
            <ButtonAntd
              type="primary"
              htmlType="submit"
              style={{ height: '45px' }}
              onKeyPress={handleSignIn}
            >
              {SIGN_IN}
            </ButtonAntd>
          </Form.Item>
        </Form>
        <Div
          style={{
            textAlign: 'center',
            marginTop: '10px',
            marginBottom: '30px',
          }}
        >
          <Link to={SIGN_UP_URL}> {SIGN_UP} </Link> /
          <Link to={SIGN_UP_URL}> {SEARCH_ID} </Link> /
          <Link to={SIGN_UP_URL}> {SEARCH_PASSWORD}</Link>
        </Div>
      </InnerWrapper>
    </Wrapper>
  );
}

export default SignIn;
