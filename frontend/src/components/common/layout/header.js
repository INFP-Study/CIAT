import React from 'react';
import { Affix, Layout } from 'antd';
import { SIGN_IN, TITLE } from '../../../constants';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { MAIN_URL, SIGN_IN_URL } from '../../../constants/urls';
import { MdAccountCircle } from 'react-icons/md';
import { theme } from '../../../style/theme';

const { Header } = Layout;

const HeaderStyle = {
  //Header 태그 참조 이슈가 있어 스타일 방법 변경
  display: 'flex',
  justifyContent: 'space-between',
  height: '70px',
  padding: '10px 40px',
  alignItems: 'center',
  backgroundColor: `${theme.colorWhite}`,
  borderBottom: `${theme.borderLine}`,
};

const Logo = styled(Link)`
  font-family: ${theme.fontLogo};
  font-size: ${theme.fontSizeLogo};
  color: ${theme.colorPrimary};
  :hover {
    color: ${theme.colorPrimary};
  }
`;

const UserInfo = styled(Link)`
  display: flex;
  align-items: center;
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  color: ${theme.colorText};
  :hover {
    color: ${theme.colorText};
  }
`;

function SiteHeader() {
  return (
    <Affix offsetTop={0}>
      <Header style={HeaderStyle}>
        <Logo to={MAIN_URL}>{TITLE}</Logo>
        <UserInfo to={SIGN_IN_URL}>
          <MdAccountCircle
            style={{ fontSize: theme.fontSizeIcon, margin: '0px 10px' }}
          />
          {SIGN_IN}
        </UserInfo>
      </Header>
    </Affix>
  );
}

export default SiteHeader;
