import React from 'react';
import PlantManagementContainer from '../containers/plantManagement';
import styled from 'styled-components';

const Wrapper = styled.div`
  height: 100%;
  min-width: 1500px;
  min-height: 680px;
  justify-content: center;
  align-items: center;
  display: flex;
`;

function PlantManagement() {
  return (
    <Wrapper>
      <PlantManagementContainer />
    </Wrapper>
  );
}

export default PlantManagement;
