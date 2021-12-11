import React from 'react';
import PlantManagementContainer from '../containers/plantManagement';
import styled from 'styled-components';

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  max-width: 1200px;
  max-height: 570px;
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
