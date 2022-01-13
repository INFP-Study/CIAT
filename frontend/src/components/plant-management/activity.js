import { Card, Space } from 'antd';
import React, { useState } from 'react';
import styled from 'styled-components';
import useDynamicIcon from '../../hooks/useDynamicIcon';
import { theme } from '../../style/theme';

const ActivityCard = styled(Card)`
  width: 850px;
  height: 400px;
`;

const Title = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightMid};
`;

const SubTitle = styled.p`
  font-size: ${theme.fontSizeBody01};
`;

const getItemList = (items) => {
  return (
    <Space size={40} style={{ display: 'flex', justifyContent: 'center' }}>
      {items.map((item) => (
        <Space direction="vertical" key={item.id}>
          {useDynamicIcon(item.icon)}
          <p style={{ textAlign: 'center' }}>{item.name}</p>
        </Space>
      ))}
    </Space>
  );
};

function Activity({ plantName, data }) {
  const { activityData, statData } = data;
  return (
    <ActivityCard>
      <Title>{plantName}</Title>
      <SubTitle>활동</SubTitle>
      {getItemList(activityData)}
      <SubTitle>상태</SubTitle>
      {getItemList(statData)}
    </ActivityCard>
  );
}

export default Activity;
