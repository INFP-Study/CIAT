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
    padding-bottom: 10px;
  }
  .memo > .ant-card-body {
    padding-top: 10px;
    height: 73%;
  }
  .ant-card-head-title {
    padding: 3px 0;
  }
  .ant-card-head-wrapper {
    height: 100%;
  }
`;
const PlantCard = ({ plantInfo }) => {
  return (
    <CardAntd hoverable title={plantInfo && plantInfo.title}>
      {<p>{plantInfo && plantInfo.subTitle}</p>}
      <p>{plantInfo && plantInfo.content}</p>
    </CardAntd>
  );
};

export default PlantCard;
