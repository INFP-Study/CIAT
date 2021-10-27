import React, { Children } from 'react';
import { Input, Button, Space } from 'antd';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import SiteLayout from '../../components/common/layout';
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
  width: 500px;
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
  height: 700px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 700px;
  height: 400px;
`;

const SNSLogin = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  border-top: 1px solid ${theme.colorLine};
  padding: 30px;
`;

function SignIn() {
  return (
    <SiteLayout>
      <Wrapper>
        <InnerWrapper>
          <Title>{SIGN_IN}</Title>
          <Div>
            {EMAIL}
            <Input
              placeholder="이메일 주소를 입력해주세요."
              style={{ marginTop: '10px' }}
            />
          </Div>
          <Div>
            {PASSWORD}
            <Input.Password
              placeholder="비밀번호를 입력해주세요."
              style={{ marginTop: '10px' }}
            />
          </Div>
          <Div>
            <ButtonAntd type="primary" style={{ height: '44px' }}>
              {SIGN_IN}
            </ButtonAntd>
          </Div>
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
          <SNSLogin>
            <Space>
              <AppleOutlined style={{ fontSize: '30px' }} />
              Apple 로그인
              <FacebookOutlined style={{ fontSize: '30px' }} />
              Facebook 로그인
              <GithubOutlined style={{ fontSize: '30px' }} />
              Github 로그인
              <InstagramOutlined style={{ fontSize: '30px' }} />
              Instagram 로그인
            </Space>
          </SNSLogin>
        </InnerWrapper>
      </Wrapper>
      {/* 로그인 API 향후 개발 */}
    </SiteLayout>
  );
}

export default SignIn;
