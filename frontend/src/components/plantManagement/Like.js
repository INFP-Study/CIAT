import React from 'react';
import styled from 'styled-components';
import { Card } from 'antd';
import { BsSun } from 'react-icons/bs';
import { GiWaterDrop } from 'react-icons/gi';
import { FaThermometerQuarter } from 'react-icons/fa';

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

const Container = styled.div`
  display: flex;
  justify-content: space-around;
`;

const AntdSun = styled(BsSun)`
  color: #DA9393;
`;

const AntdDrop = styled(GiWaterDrop)`
  color: #A0C4C9;
`;

const AntdQuarter = styled(FaThermometerQuarter)`
  color: #E3B074;
`;
const Like = () => {
  return (
    <CardAntd hoverable title={'Like'}>
      <Container>
        <p style={{width: '2em'}}>햇빛</p>
        <AntdSun size={'1.5em'} />
        <AntdSun size={'1.5em'} />
        <AntdSun size={'1.5em'} />
        <AntdSun size={'1.5em'} />
        <AntdSun size={'1.5em'} />
      </Container>
      <Container>
        <p style={{width: '2em'}}>물</p>
        <AntdDrop size={'1.5em'} />
        <AntdDrop size={'1.5em'} />
        <AntdDrop size={'1.5em'} />
        <AntdDrop size={'1.5em'} />
        <AntdDrop size={'1.5em'} />
      </Container>
      <Container>
        <p style={{width: '2em'}}>햇빛</p>
        <AntdQuarter size={'1.5em'} />
        <AntdQuarter size={'1.5em'} />
        <AntdQuarter size={'1.5em'} />
        <AntdQuarter size={'1.5em'} />
        <AntdQuarter size={'1.5em'} />
      </Container>
    </CardAntd>
  );
};

export default Like;