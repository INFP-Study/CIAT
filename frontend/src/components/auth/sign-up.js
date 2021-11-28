import React, { useState } from 'react';
import { Input, Checkbox, Button, Alert, message } from 'antd';
import styled from 'styled-components';
import {
  EMAIL,
  ESSENTIAL,
  ESSENTIAL_TEXT,
  NICK_NAME,
  PASSWORD,
  PASSWORD_CONFIRM,
  SIGN_UP,
  TERMS_OF_USE,
  USER_INFO,
  FULL_CONSENT,
  REQUIRED_CHECK,
} from '../../constants';
import { theme } from '../../style/theme';

const CheckboxGroup = Checkbox.Group;
const plainOptions = [
  '이용약관동의',
  '개인정보처리방침 동의',
  '개인정보 수집 및 이용 동의',
];

const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 700px;
`;

const Title = styled.p`
  font-family: ${theme.fontNotoSans};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightBold};
`;

const Essential = styled.span`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-end;
`;

const EssentialText = styled.span`
  margin-left: 7px;
  font-size: ${theme.fontSizeBody03};
  color: #ff0000;
`;

const Div = styled.div`
  padding: 12.5px;
  padding-top: 21px;
  width: 550px;
`;

const TopLine = styled.div`
  border-top: 1px solid ${theme.colorLine};
`;

const ButtonAntd = styled(Button)`
  width: 500px;
  height: 50px;
  font-size: ${theme.fontSizeTitle02};
  border-radius: 6px;
  margin-top: 10px;
`;

function SignUp({ handleChange, handleSignUp, emptyValueCheck }) {
  const [checkedList, setCheckedList] = useState('');
  const [checkAll, setCheckAll] = useState(false);

  const onChange = (list) => {
    setCheckedList(list);
    setCheckAll(list.length === plainOptions.length);
  };

  const onCheckAllChange = (e) => {
    setCheckedList(e.target.checked ? plainOptions : []);
    setCheckAll(e.target.checked);
  };

  return (
    <Wrapper>
      <InnerWrapper>
        <Title>{SIGN_UP}</Title>
        <Div>
          {USER_INFO}
          <TopLine style={{ marginTop: '10px' }} />
          <Essential style={{ fontSize: '12px', paddingTop: '4px' }}>
            *{ESSENTIAL}
          </Essential>
        </Div>
        <Div>
          <EssentialText>*</EssentialText>
          {EMAIL}
          <Input
            style={{ marginTop: '9px' }}
            name="email"
            className="input-area"
            onChange={handleChange}
            onBlur={emptyValueCheck}
            placeholder="이메일 주소를 입력해주세요."
          />
        </Div>
        <Div>
          <EssentialText>*</EssentialText>
          {NICK_NAME}
          <Input
            style={{ marginTop: '9px' }}
            name="nickname"
            onChange={handleChange}
            onBlur={emptyValueCheck}
            placeholder="닉네임을 입력해주세요."
          />
        </Div>
        <Div>
          <EssentialText>*</EssentialText>
          {PASSWORD}
          <Input.Password
            style={{ marginTop: '9px' }}
            name="password"
            onChange={handleChange}
            onBlur={emptyValueCheck}
            placeholder="비밀번호를 입력해주세요."
          />
        </Div>
        <Div>
          <EssentialText>*</EssentialText>
          {PASSWORD_CONFIRM}
          <Input.Password
            style={{ marginTop: '9px' }}
            name="passwordConfirm"
            onChange={handleChange}
            onBlur={emptyValueCheck}
            placeholder="비밀번호 확인을 입력해주세요."
          />
        </Div>
        <Div style={{ marginTop: '65px' }}>
          {TERMS_OF_USE}
          <TopLine style={{ marginTop: '10px' }} />
        </Div>
        <Div>
          <Checkbox onChange={onCheckAllChange} checked={checkAll}>
            {FULL_CONSENT}
          </Checkbox>
        </Div>
        <Div>
          <CheckboxGroup
            options={plainOptions}
            value={checkedList}
            onChange={onChange}
          />
        </Div>
        <Div>
          <ButtonAntd type="primary" onClick={handleSignUp}>
            {SIGN_UP}
          </ButtonAntd>
        </Div>
      </InnerWrapper>
    </Wrapper>
  );
}

export default SignUp;
