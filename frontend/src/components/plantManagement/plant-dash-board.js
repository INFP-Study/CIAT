import React from 'react';
import { Card } from 'antd';
import { BsEmojiLaughingFill, BsEmojiNeutralFill, BsEmojiFrownFill, BsEmojiDizzyFill, BsSnow } from 'react-icons/bs';
import styled from 'styled-components';
import { IoLeafSharp, IoLeafOutline, IoColorFillOutline, IoSunnyOutline, IoSearchSharp } from 'react-icons/io5';
import { IoMdFlower } from 'react-icons/io';
import { BiSprayCan, BiWind } from 'react-icons/bi';
import { RiPlantLine, RiScissors2Fill } from 'react-icons/ri';
import { VscArchive } from 'react-icons/vsc';

const DashCard = styled(Card)`
  width: 100%;
  height: 100%;
  .ant-card-body {
    height: 100%;
  }
`
const EmoticonBox = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
`;

const Container = styled.div`
  display: flex;
  justify-content: space-around;
  height: 50%;
  span {
    margin-top: 15px;
  }
`;

const PlantDashBoard = () => {
  return (
    <DashCard hoverable>
      <Container>
        <div>활동</div>
        <EmoticonBox>
          <IoColorFillOutline size={'3em'} color={'#A0C4C9'} />
          <span>물주기</span>
        </EmoticonBox>
        <EmoticonBox>
          <IoSunnyOutline size={'3em'} color={'#DA9393'} />
          <span>햇빛</span>
        </EmoticonBox>
        <EmoticonBox>
          <BiWind size={'3em'} color={'#96A8CB'} />
          <span>통풍</span>
        </EmoticonBox>
        <EmoticonBox>
          <VscArchive size={'3em'} color={'#C6C6C6'} />
          <span>분갈이</span>
        </EmoticonBox>
        <EmoticonBox>
          <RiPlantLine size={'3em'} color={'#C6C6C6'} />
          <span>영양</span>
        </EmoticonBox>
        <EmoticonBox>
          <RiScissors2Fill size={'3em'} color={'#C6C6C6'} />
          <span>가지</span>
        </EmoticonBox>
        <EmoticonBox>
          <BiSprayCan size={'3em'} color={'#C6C6C6'} />
          <span>분무</span>
        </EmoticonBox>
        <EmoticonBox>
          <IoSearchSharp size={'3em'} color={'#3F3D3D'} />
          <span>관찰</span>
        </EmoticonBox>
      </Container>
      <Container>
        <div>상태</div>
        <EmoticonBox>
          <BsEmojiLaughingFill size={'3em'} color={'#96A8CB'} />
          <span>좋음</span>
        </EmoticonBox>
        <EmoticonBox>
          <BsEmojiNeutralFill size={'3em'} color={'#7EA592'} />
          <span>보통</span>
        </EmoticonBox>
        <EmoticonBox>
          <BsEmojiFrownFill size={'3em'} color={'#AD9CBB'} />
          <span>나쁨</span>
        </EmoticonBox>
        <EmoticonBox>
          <BsEmojiDizzyFill size={'3em'} color={'#DA9393'} />
          <span>죽음</span>
        </EmoticonBox>
        <EmoticonBox>
          <IoLeafSharp size={'3em'} color={'#C0D3A7'} />
          <span>새싹</span>
        </EmoticonBox>
        <EmoticonBox>
          <IoMdFlower size={'3em'} color={'#FBD899'} />
          <span>개화</span>
        </EmoticonBox>
        <EmoticonBox>
          <IoLeafOutline size={'3em'} color={'#887665'} />
          <span>마름</span>
        </EmoticonBox>
        <EmoticonBox>
          <BsSnow size={'3em'} color={'#ADEBFF'} />
          <span>추움</span>
        </EmoticonBox>
      </Container>
    </DashCard>
  );
};

export default PlantDashBoard;