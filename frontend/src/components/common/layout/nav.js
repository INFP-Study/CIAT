import React from 'react';
import { Affix, Button, Menu, Popconfirm } from 'antd';
import * as AntdIcons from '@ant-design/icons';
import styled from 'styled-components';
import { theme } from '../../../style/theme';
import { Link } from 'react-router-dom';
import { DOCUMENT_URL, GITHUB_URL, SETTING_URL } from '../../../constants/urls';
import Category from './category';

const Wrapper = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 67px;
  border-right: ${theme.colorLine};
  padding: 30px 0px;
  background-color: ${theme.colorNav};
`;
const TopMenu = styled.div``;

const BottomMenu = styled.div``;

const MenuAntd = styled(Menu)`
  background-color: ${theme.colorNav};
  .ant-menu-item:hover,
  .ant-menu-submenu:hover,
  .ant-menu-item-active,
  .ant-menu-submenu-active,
  .ant-menu-item-open,
  .ant-menu-submenu-open,
  .ant-menu-item-selected,
  .ant-menu-submenu-selected {
    background-color: ${theme.colorNav} !important;
  }
  .ant-menu-item::after {
    border-right: 0px;
  }
`;

function Nav({ menuList, location }) {
  //아이콘 동적 로딩 -> 커스텀 hook으로 생성하면 좋을 듯?
  const DynamicIcon = (iconName) => {
    const { ...icons } = AntdIcons;
    const TheIcon = icons[iconName];

    return <TheIcon style={{ fontSize: theme.fontSizeIcon }} />;
  };

  const getMenu = (menuList) => {
    return menuList.map((menu) => {
      return (
        <Menu.Item key={menu.url} icon={DynamicIcon(menu.icon)}>
          <Link to={menu.url} />
        </Menu.Item>
      );
    });
  };
  return (
    <>
      <Affix offsetTop={0}>
        <Wrapper>
          <TopMenu>
            {/* 상단 메뉴 */}
            <MenuAntd
              mode="inline"
              selectedKeys={location.pathname}
              defaultSelectedKeys={location.pathname}
            >
              {menuList.length !== 0 && getMenu(menuList)}
            </MenuAntd>
          </TopMenu>

          {/* 하단 메뉴*/}
          <BottomMenu>
            <MenuAntd
              mode="inline"
              selectedKeys={location.pathname}
              defaultSelectedKeys={location.pathname}
            >
              <Menu.Item
                key={SETTING_URL}
                icon={
                  <AntdIcons.SettingOutlined
                    style={{ fontSize: theme.fontSizeIcon }}
                  />
                }
              >
                <Link to={SETTING_URL} />
              </Menu.Item>
              <Menu.Item
                key={DOCUMENT_URL}
                icon={
                  <AntdIcons.FileTextOutlined
                    style={{ fontSize: theme.fontSizeIcon }}
                  />
                }
              >
                <Link to={DOCUMENT_URL} />
              </Menu.Item>

              <Menu.Item
                key={GITHUB_URL}
                icon={
                  <AntdIcons.GithubOutlined
                    style={{ fontSize: theme.fontSizeIcon }}
                  />
                }
              >
                <Link to={{ pathname: GITHUB_URL }} target="_blank" />
              </Menu.Item>
            </MenuAntd>
          </BottomMenu>
        </Wrapper>
      </Affix>
    </>
  );
}

export default Nav;
