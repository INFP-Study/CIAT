import React from 'react';
import PlantManagementContainer from '../containers/plantManagement';
import styled from 'styled-components';

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  min-width: 1500px;
  min-height: 680px;
  justify-content: center;
  align-items: center;
`;

function PlantManagement() {
  return (
    <Wrapper>
      <PlantManagementContainer />
    </Wrapper>
  );
}

export default PlantManagement;
