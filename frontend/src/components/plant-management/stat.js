import { Card, Space } from 'antd';
import React from 'react';
import styled, { css } from 'styled-components';
import { theme } from '../../style/theme';
import { MdOutlineWbSunny, MdWaterDrop, MdThermostat } from 'react-icons/md';
const StatCard = styled(Card)`
  width: 430px;
  height: 190px;
`;

const Title = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  font-weight: ${theme.weightMid};
`;

const TypeName = styled.p`
  width: 30px;
  text-align: center;
`;

const DDay = styled.div`
  display: flex;
  justify-content: space-around;
`;

const Circle = styled.div`
  background: gray;
  ${({ type }) => {
    return type === 'water'
      ? `background: #8BCEE3;` //물주기
      : type === 'supplements'
      ? `background: #E3B074;` //영양제
      : `background: #DCC6A5;`; //분갈이
  }}
  width: 80px;
  height: 80px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: ${theme.fontSizeBody03};
`;

const sun = { color: '#DA9393', fontSize: '30px' };
const water = { color: '#A0C4C9', fontSize: '30px' };
const temp = { color: '#E3B074', fontSize: '30px' };

function Stat({ title }) {
  return (
    <StatCard>
      <Title>{title}</Title>
      {title === '디데이' ? (
        <DDay>
          <Space direction="vertical" align="center">
            <Circle type={'water'}>D-9</Circle> <p>물</p>
          </Space>
          <Space direction="vertical" align="center">
            <Circle type={'supplements'}>D-86</Circle> <p>영양제</p>
          </Space>
          <Space direction="vertical" align="center">
            <Circle type={'repotting'}>D-186</Circle> <p>분갈이</p>
          </Space>
        </DDay>
      ) : (
        <Space direction="vertical" size={5}>
          <Space size={70}>
            <TypeName>햇빛</TypeName>
            <Space size={30}>
              <MdOutlineWbSunny style={sun} />
              <MdOutlineWbSunny style={sun} />
              <MdOutlineWbSunny style={sun} />
              <MdOutlineWbSunny style={sun} />
              <MdOutlineWbSunny style={sun} />
            </Space>
          </Space>
          <Space size={70}>
            <TypeName>물</TypeName>
            <Space size={30}>
              <MdWaterDrop style={water} />
              <MdWaterDrop style={water} />
              <MdWaterDrop style={water} />
              <MdWaterDrop style={water} />
              <MdWaterDrop style={water} />
            </Space>
          </Space>
          <Space size={70}>
            <TypeName>온도</TypeName>
            <Space size={30}>
              <MdThermostat style={temp} />
              <MdThermostat style={temp} />
              <MdThermostat style={temp} />
              <MdThermostat style={temp} />
              <MdThermostat style={temp} />
            </Space>
          </Space>
        </Space>
      )}
    </StatCard>
  );
}

export default Stat;
