import { Skeleton, Space } from 'antd';
import React from 'react';
import styled from 'styled-components';
import { theme } from '../style/theme';

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
const Title = styled.p`
  font-size: 50px;
  color: ${theme.colorPrimary};
  font-weight: ${theme.weightMid};
  font-family: 'Righteous';
`;
const SubTitle = styled.p`
  font-size: ${theme.fontSizeLogo};
  text-align: center;
  font-weight: ${theme.weightBold};
`;

function Home() {
  return (
    <Wrapper>
      <Title>CIAT PROJECT</Title>
      <img src={require('../assets/images/blooming.png')} width={300} />
      <SubTitle>
        안녕하세요
        <br />
        씨앗 프로젝트를 소개합니다.
      </SubTitle>
      <br />
      <SubTitle>HOW WE START</SubTitle>
      <img src={require('../assets/images/cyrm.png')} width={400} />
    </Wrapper>
  );
}

export default Home;
