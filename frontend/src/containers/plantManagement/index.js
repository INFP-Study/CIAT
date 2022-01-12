import React, { useState } from 'react';
import styled from 'styled-components';
import { Col, Row } from 'antd';
import Memo from '../../components/plantManagement/memo';
import Log from '../../components/plantManagement/log';
import PlantCard from '../../components/plantManagement/plant-card';
import CareCard from '../../components/plantManagement/care-card';
import ImageCard from '../../components/plantManagement/image-card';
import ActiveChart from '../../components/plantManagement/active-chart';
import StateChart from '../../components/plantManagement/state-chart';
import PlantDashBoard from '../../components/plantManagement/plant-dash-board';
import Dday from '../../components/plantManagement/d-day';
import Like from '../../components/plantManagement/Like';

const collStyle = {
  display: 'flex',
  justifyContent: 'space-between',
  flexDirection: 'column',
  width: '40vh',
};

const colItemStyle = {
  maxHeight: '40vh',
  maxWidth: '40vh',
  minWidth: '330px',
  minHeight: '330px',
  display: 'flex',
  flexDirection: 'column',
  justifyContent: 'space-between'
};

const colItemStyle2 = {
  maxHeight: '40vh',
  maxWidth: '80vh',
  minWidth: '660px',
  minHeight: '330px',
};
const Wrapper = styled.div`
  height: 100%;
`;

const PlantManagementContainer = () => {
  const [plantInfo, setPlantInfo] = useState({
    title: '토마토',
    subTitle: '가지목 가지과',
    content: '남아메리카, 중앙아메리카',
  });
  const [careInfo, setCareInfo] = useState({
    title: '관리방법',
    content:
      '방울토마토를 비롯해 집에서 채소를 키우려면 상토를 화분에 넣고, 중앙에 2/3나 3/4 정도 너무 깊지 않게 씨앗이나 모종을 심는 것이 중요',
  });
  return (
      <Row gutter={[16, 16]} style={{ height: '100%', maxWidth: '1653px'}}>
        <Col className='gutter-row' span={8} style={colItemStyle}>
          <ImageCard />
        </Col>
        <Col className='gutter-row' span={12} style={colItemStyle2}>
          <PlantDashBoard />
        </Col>
        <Col className='gutter-row' span={6} style={collStyle}>
          <PlantCard plantInfo={plantInfo} />
          <CareCard careInfo={careInfo} />
        </Col>
        <Col className='gutter-row' span={6} style={colItemStyle}>
          <StateChart />
        </Col>
        <Col className='gutter-row' span={6} style={colItemStyle}>
          <ActiveChart />
        </Col>
        <Col className='gutter-row' span={6} style={colItemStyle}>
          <Dday />
          <Like />
        </Col>
        <Col className='gutter-row' span={6} style={colItemStyle}>
          <Log />
          <Memo />
        </Col>
      </Row>
  );
};

export default PlantManagementContainer;
