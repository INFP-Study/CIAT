import React from 'react';
import styled from 'styled-components';
import { Card } from 'antd';

const CardAntd = styled(Card)`
  height: 47%;
  width: 40vh;
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
const CareCard = ({ careInfo }) => {
  return (
    <CardAntd hoverable title={careInfo && careInfo.title}>
      {careInfo && careInfo.content}
      <p style={{ color: 'blue' }}>더보기...</p>
    </CardAntd>
  );
};

export default CareCard;
