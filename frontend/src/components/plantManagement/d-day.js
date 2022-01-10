import React from 'react';
import styled from 'styled-components';
import { Card } from 'antd';

const CardAntd = styled(Card)`
  height: 47%;
  .ant-card-head {
    min-height: 30px;
  }
  .ant-card-body {
    padding: 10px;
    height: 75%;
  }
  .ant-card-head-title {
    padding: 3px 0;
  }
  .ant-card-head-wrapper {
    height: 100%;
  }
`;

const Circle = styled.div`
  width: 1px;
  height: 1px;
  border: 1px;
  border-radius: 50%;
  margin: auto;
  font-size: 1.5vh;
  width: 6em;
  height: 6em;
  justify-content: center;
  display: flex;
  flex-direction: column;
`;

const Wrapper = styled.div`
  display: flex;
  height: 100%;
  justify-content: space-around;
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
`;

const Title = styled.p`
  margin-top: 5px;
  margin-bottom: 0;
`;

const Dday = () => {
  return (
    <CardAntd hoverable title={'디데이'}>
      <Wrapper>
        <Container>
          <Circle style={{ backgroundColor: '#8BCEE3' }}>D-9</Circle>
          <Title>물</Title>
        </Container>
        <Container>
          <Circle style={{ backgroundColor: '#E3B074' }}>D-86</Circle>
          <Title>영양제</Title>
        </Container>
        <Container>
          <Circle style={{ backgroundColor: '#DCC6A5' }}>D-186</Circle>
          <Title>분갈이</Title>
        </Container>
      </Wrapper>
    </CardAntd>
  );
};

export default Dday;