import { Card, Input } from 'antd';
import React from 'react';
import styled from 'styled-components';
import { theme } from '../../style/theme';

const { TextArea } = Input;

const MemoCard = styled(Card)`
  width: 303px;
  height: 190px;
  background-color: ${theme.colorMemo};
`;

const Title = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  font-weight: ${theme.weightMid};
`;

function Memo({ title }) {
  return (
    <MemoCard>
      <Title>{title}</Title>
      <TextArea
        placeholder={'메모를 이용하여 나만의 식물 정보를 기록해보세요.'}
        rows={5}
        bordered={false}
        style={{ margin: 0, padding: 0 }}
        maxLength={200}
      />
    </MemoCard>
  );
}

export default Memo;
