import React from 'react';
import PlantManagementContainer from '../containers/plant-management-container';

function PlantManagement() {
  //상세보기 들어갈 때 스크롤 위치 상단으로 초기화
  window.scrollTo(0, 0);

  return <PlantManagementContainer />;
}

export default PlantManagement;
