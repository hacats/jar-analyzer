package me.n1ar4.jar.analyzer.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import me.n1ar4.jar.analyzer.entity.LuceneSearchResult;
import me.n1ar4.jar.analyzer.gui.util.IconManager;
import me.n1ar4.jar.analyzer.lucene.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LuceneSearchForm {
    private JPanel rootPanel;
    private JPanel searchInputPanel;
    private JLabel searchIconLabel;
    private JTextField searchText;
    private JScrollPane searchScroll;
    private JList<LuceneSearchResult> searchResultList;
    private JPanel searchOptionPanel;
    private JRadioButton containsRadio;
    private JRadioButton regexRadio;
    private JButton luceneBuildBtn;
    private JRadioButton noLuceneRadio;
    private JRadioButton paLuceneRadio;
    private JPanel searchOptionsPanel;
    private JLabel luceneSizeLabel;

    private static LuceneSearchForm instance;
    private static JFrame instanceFrame;

    public static boolean usePaLucene() {
        return instance.paLuceneRadio.isSelected();
    }

    public static boolean useNoLucene() {
        return instance.noLuceneRadio.isSelected();
    }

    public static boolean useContains() {
        return instance.containsRadio.isSelected();
    }

    public static boolean useRegex() {
        return instance.regexRadio.isSelected();
    }

    public static JButton getBuildButton() {
        return instance.luceneBuildBtn;
    }

    public static LuceneSearchForm getInstance() {
        return instance;
    }

    public static JFrame getInstanceFrame() {
        return instanceFrame;
    }

    private void init() {
        containsRadio.setSelected(true);
        paLuceneRadio.setSelected(true);

        luceneBuildBtn.addActionListener(new LuceneBuildListener());
        searchResultList.setCellRenderer(new LuceneResultRender());
        searchResultList.addMouseListener(new LuceneMouseListener());

        searchIconLabel.setIcon(IconManager.gsIcon);
        LuceneSearchListener listener = new LuceneSearchListener(searchText, searchResultList);
        searchText.getDocument().addDocumentListener(listener);
        new LuceneIndexWatcher(luceneSizeLabel).start();
    }

    public static void start() {
        // 全局只有一个 LuceneSearchForm GUI 对象
        if (instanceFrame == null) {
            instanceFrame = new JFrame();
            instanceFrame.setUndecorated(true);

            Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            instanceFrame.setLocation(mouseLocation.x + 10, mouseLocation.y + 10);

            instance = new LuceneSearchForm();
            instance.init();
            instanceFrame.setContentPane(instance.rootPanel);
            instanceFrame.pack();
            instanceFrame.setVisible(true);
        } else {
            instanceFrame.setVisible(true);
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        searchInputPanel = new JPanel();
        searchInputPanel.setLayout(new GridLayoutManager(2, 3, new Insets(8, 3, 3, 3), -1, -1));
        rootPanel.add(searchInputPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        searchIconLabel = new JLabel();
        searchIconLabel.setText("");
        searchInputPanel.add(searchIconLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchText = new JTextField();
        searchInputPanel.add(searchText, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(200, -1), null, 0, false));
        searchOptionPanel = new JPanel();
        searchOptionPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        searchInputPanel.add(searchOptionPanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        containsRadio = new JRadioButton();
        containsRadio.setText("contains");
        searchOptionPanel.add(containsRadio, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        regexRadio = new JRadioButton();
        regexRadio.setText("regexp");
        searchOptionPanel.add(regexRadio, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchOptionsPanel = new JPanel();
        searchOptionsPanel.setLayout(new GridLayoutManager(2, 2, new Insets(3, 3, 3, 3), -1, -1));
        searchInputPanel.add(searchOptionsPanel, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        searchOptionsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "索引设置", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        noLuceneRadio = new JRadioButton();
        noLuceneRadio.setText("不使用 Lucene 索引 (仅搜索类名/文件名)");
        searchOptionsPanel.add(noLuceneRadio, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        paLuceneRadio = new JRadioButton();
        paLuceneRadio.setText("被动构建 Lucene 索引 (每次反编译代码自动提交)");
        searchOptionsPanel.add(paLuceneRadio, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        luceneSizeLabel = new JLabel();
        luceneSizeLabel.setText("当前索引大小：0 MB");
        searchOptionsPanel.add(luceneSizeLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        luceneBuildBtn = new JButton();
        luceneBuildBtn.setText("手动构建完整索引");
        searchOptionsPanel.add(luceneBuildBtn, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchScroll = new JScrollPane();
        rootPanel.add(searchScroll, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(600, 400), new Dimension(600, 400), new Dimension(600, 400), 0, false));
        searchResultList = new JList();
        searchScroll.setViewportView(searchResultList);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(containsRadio);
        buttonGroup.add(regexRadio);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(noLuceneRadio);
        buttonGroup.add(paLuceneRadio);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
